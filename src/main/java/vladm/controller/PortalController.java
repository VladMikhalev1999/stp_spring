package vladm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {

    @RequestMapping(value = "/employees")
    public String employeesList() { return "employees"; }

    @RequestMapping(value = "/statuses")
    public String statusesList() { return "statuses"; }

    @RequestMapping(value = "")
    public String mainPage() { return "main"; }

    @RequestMapping(value = "/addStatus")
    public String showAddStatusForm() { return "addStatus"; }

    @RequestMapping(value = "/removeStatus")
    public String showRemoveStatusForm() { return "removeStatus"; }

    @RequestMapping(value = "/setStatus")
    public String showUpdateStatusForm() { return "setStatus"; }

    @RequestMapping(value = "/addEmployee")
    public String showAddEmployeeForm() { return "addEmployee"; }

    @RequestMapping(value = "/removeEmployee")
    public String showRemoveEmployeeForm() { return "removeEmployee"; }

    @RequestMapping(value = "/setEmployee")
    public String showUpdateEmployeeForm() { return "setEmployee"; }

    @RequestMapping(value = "/addEmployeeStatus")
    public String showAddEmpStatForm() { return "addEmployeeStatus"; }

    @RequestMapping(value = "/removeEmployeeStatus")
    public String showRemoveEmpStatForm() { return "removeEmployeeStatus"; }
}
