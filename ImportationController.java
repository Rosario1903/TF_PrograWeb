package pe.edu.upc.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.ImportDetails;
import pe.edu.upc.entity.Importation;
import pe.edu.upc.serviceinterface.IClienteService;
import pe.edu.upc.serviceinterface.IDescuentoService;
import pe.edu.upc.serviceinterface.IImportDetailService;
import pe.edu.upc.serviceinterface.IImportationService;
import pe.edu.upc.serviceinterface.ILocalService;
import pe.edu.upc.serviceinterface.IOfertaService;
import pe.edu.upc.serviceinterface.IProductService;

@Controller
@RequestMapping("/importations")
public class ImportationController {

	@Autowired
	private IImportationService iS;

	@Autowired
	private IProductService pS;

	@Autowired
	private IImportDetailService ideS;
	
	@Autowired
	private ILocalService lS;
	
	@Autowired
	private IClienteService cS;
	
	@Autowired
	private IOfertaService oS;
	
	@Autowired
	private IDescuentoService dS;
	
	@RequestMapping("/reports")
	public String Report()
	{
		return "reports/reports";
	}
	
	@RequestMapping("/new")
	public String irRegistrar(Model model) {
		model.addAttribute("importation", new Importation());
		return "importation/importation";
	}



	@RequestMapping("/newproduct/{id}")
	public String irNewProduct(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		model.put("detail", new ImportDetails());
		model.put("listaProductos", pS.list());
		model.put("listaLocales", lS.list());
		model.put("listaOfertas", oS.list());
		model.put("listaClientes", cS.listCliente());
		model.put("listaDescuentos", dS.listDescuento());

		Importation objimp = iS.listarId(id);
		model.put("importation", objimp);

		return "importation/details/detailForm";
	}


	@RequestMapping("/list")
	public String listar(Map<String, Object> model) {
		model.put("listaImportations", iS.listar());
		return "importation/listImportation";
	}

	@GetMapping("/detail/{id}")
	public String detailImportation(@PathVariable(value = "id") Long id, Map<String, Object> model,
			RedirectAttributes flash) {
		Importation imp = iS.listarId(id);

		if (imp == null) {
			flash.addFlashAttribute("error", "El Detalle no existe en la base de datos");
			return "importation/listImportation"; 
		}
		model.put("importation", imp);
		model.put("titulo", "Detalle de Importacion #" + imp.getIdImportation());

		return "importation/details/listDetail"; 
	}

	@PostMapping("/save")
	public String saveOrder(@Valid Importation importation, Model model, SessionStatus status, BindingResult binRes) {
		Date requestday = new Date();
		try {
			importation.setRequestDate(requestday);
			iS.insert(importation);
			status.setComplete();
			model.addAttribute("success", "Orden Generada");
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "redirect: /importations/new";
		}

		return "redirect:/importations/list";
	}

	@PostMapping("/saveproduct{id}")
	public String newProductXImportation(@PathVariable(value = "id") long id, @Valid ImportDetails importationdet,
			RedirectAttributes flash, BindingResult result, Model model, SessionStatus status) {
		Importation imp = iS.listarId(id);
		if (result.hasErrors()) {
			flash.addFlashAttribute("error", "El valor debe ser positivo");
			String cadena1 = "redirect:/importation/newproduct/" + id;
			return cadena1;
		}
		try {
			imp.addDetailImportation(importationdet);
			iS.insert(imp);
			status.isComplete();
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			System.out.println(e.getMessage());
		}
		String cadena = "redirect:/importations/detail/" + id;
		return cadena;
	}


	@RequestMapping("{idimp}/eliminardetail/{id}")
	public String eliminarDetalle(Map<String, Object> model, @PathVariable(value = "id") Long idet,
			@PathVariable(value = "idimp") Long idimp, RedirectAttributes flash) {
		try {
			if (idet != null && idet > 0) {
				ideS.delete(idet);
				flash.addAttribute("mensaje", "Se eliminó correctamente");
				flash.addAttribute("mensaje1", "Se eliminó correctamente el id" + idet);
			} else
				return "redirect:/home";
		} catch (Exception e) {
			model.put("mensaje", "No se puede eliminar");
			model.put("error", e.getMessage());
		}
		String cadena = "redirect:/importations/detail/" + idimp;
		return cadena;
	}

}
