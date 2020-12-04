package vladm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {

    @RequestMapping(value = "/employees")
    public String employeesList() { return "employees"; }

    @RequestMapping(value = "/statuses")
    public String statusesList() { return "statuses"; }

    @RequestMapping(value = "/auth")
    public String mainPage() { return "auth"; }

    @RequestMapping(value = "/main")
    public String loginPage() { return "main"; }

    @RequestMapping(value = "")
    public String main() { return "main"; }

    @RequestMapping(value = "/statuses/addStatus")
    public String showAddStatusForm() { return "addStatus"; }

    @RequestMapping(value = "/statuses/removeStatus")
    public String showRemoveStatusForm() { return "removeStatus"; }

    @RequestMapping(value = "/statuses/setStatus")
    public String showUpdateStatusForm() { return "setStatus"; }

    @RequestMapping(value = "/employees/addEmployee")
    public String showAddEmployeeForm() { return "addEmployee"; }

    @RequestMapping(value = "/employees/removeEmployee")
    public String showRemoveEmployeeForm() { return "removeEmployee"; }

    @RequestMapping(value = "/employees/setEmployee")
    public String showUpdateEmployeeForm() { return "setEmployee"; }

    @RequestMapping(value = "/employees/addEmployeeStatus")
    public String showAddEmpStatForm() { return "addEmployeeStatus"; }

    @RequestMapping(value = "/employees/removeEmployeeStatus")
    public String showRemoveEmpStatForm() { return "removeEmployeeStatus"; }
}
