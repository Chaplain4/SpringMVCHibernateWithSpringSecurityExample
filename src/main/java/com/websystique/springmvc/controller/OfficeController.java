package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.Office;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/offices")
@SessionAttributes("roles")
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    /**
     * This method will list all existing offices.
     */
    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String listOffices(ModelMap model) {

        List<Office> offices = officeService.findAllOffices();
        model.addAttribute("offices", offices);
        model.addAttribute("loggedinuser", getPrincipal());
        return "officelist";
    }

    /**
     * This method returns the principal[user-name] of logged-in user.
     */
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    /**
     * This method will provide the medium to add a new office.
     */
    @RequestMapping(value = {"newoffice"}, method = RequestMethod.GET)
    public String newOffice(ModelMap model) {
        Office office = new Office();
        model.addAttribute("office", office);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "newoffice";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(value = {"/newoffice"}, method = RequestMethod.POST)
    public String newOffice(@Valid Office office, BindingResult result,
                            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
        officeService.saveOffice(office);

        model.addAttribute("success", "Office " + office.getTitle() + " " + office.getAddress() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

    	@RequestMapping(value = { "delete-office-{id}" }, method = RequestMethod.GET)
    	public String deleteOffice(@PathVariable int id) {
    		officeService.deleteOfficeById(id);
    		return "redirect:/offices/list";
    	}

    	@RequestMapping(value = { "edit-office-{id}" }, method = RequestMethod.GET)
    	public String editUser(@PathVariable int id, ModelMap model) {
            Office office = officeService.findById(id);

    		model.addAttribute("office", office);
    		model.addAttribute("edit", true);
    		model.addAttribute("loggedinuser", getPrincipal());
    		return "newoffice";
    	}




    	/**
    	 * This method will be called on form submission, handling POST request for
    	 * updating user in database. It also validates the user input
    	 */
    	@RequestMapping(value = { "edit-office-{id}" }, method = RequestMethod.POST)
    	public String updateOffice(@Valid Office office, BindingResult result,
    			ModelMap model, @PathVariable int id) {

    		if (result.hasErrors()) {
    			return "newoffice";
    		}

            officeService.updateOffice(office);

    		model.addAttribute("success", "Office " + office.getTitle() + " "+ office.getAddress() + " updated successfully");
    		model.addAttribute("loggedinuser", getPrincipal());
    		return "registrationsuccess";
    	}

    //
    //
    //	/**
    //	 * This method will provide UserProfile list to views
    //	 */
    //	@ModelAttribute("roles")
    //	public List<UserProfile> initializeProfiles() {
    //		return userProfileService.findAll();
    //	}
    //
    //	/**
    //	 * This method handles Access-Denied redirect.
    //	 */
    //	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    //	public String accessDeniedPage(ModelMap model) {
    //		model.addAttribute("loggedinuser", getPrincipal());
    //		return "accessDenied";
    //	}
    //
    //	/**
    //	 * This method handles login GET requests.
    //	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
    //	 */
    //	@RequestMapping(value = "/login", method = RequestMethod.GET)
    //	public String loginPage() {
    //		if (isCurrentAuthenticationAnonymous()) {
    //			return "login";
    //	    } else {
    //	    	return "redirect:/list";
    //	    }
    //	}
    //
    //	/**
    //	 * This method handles logout requests.
    //	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
    //	 */
    //	@RequestMapping(value="/logout", method = RequestMethod.GET)
    //	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
    //		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //		if (auth != null){
    //			//new SecurityContextLogoutHandler().logout(request, response, auth);
    //			persistentTokenBasedRememberMeServices.logout(request, response, auth);
    //			SecurityContextHolder.getContext().setAuthentication(null);
    //		}
    //		return "redirect:/login?logout";
    //	}
    //
    //	/**
    //	 * This method returns the principal[user-name] of logged-in user.
    //	 */
    //	private String getPrincipal(){
    //		String userName = null;
    //		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //
    //		if (principal instanceof UserDetails) {
    //			userName = ((UserDetails)principal).getUsername();
    //		} else {
    //			userName = principal.toString();
    //		}
    //		return userName;
    //	}
    //
//    	/**
//    	 * This method returns true if users is already authenticated [logged-in], else false.
//    	 */
//    	private boolean isCurrentAuthenticationAnonymous() {
//    	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    	    return authenticationTrustResolver.isAnonymous(authentication);
//    	}
}
