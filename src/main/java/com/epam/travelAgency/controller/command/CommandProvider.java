package com.epam.travelAgency.controller.command;

import com.epam.travelAgency.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(CommandName.GOTOLOGINPAGE, new GoToLoginPage());
        commands.put(CommandName.AUTHORISATION, new Authorisation());
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
        commands.put(CommandName.SHOWWRONGMODAL, new ShowWrongModal());
        commands.put(CommandName.SHOWCATEGORIES, new ShowCategories());
        commands.put(CommandName.GOTOUSERPAGE, new GoToUserPage());
        commands.put(CommandName.GOTOREGISTRATIONPAGE, new GoToRegistrationPage());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.GOTOCHILLPAGE, new GoToChillPage());
        commands.put(CommandName.SHOWCHILLTOURSDATA, new ShowChillToursData());
        commands.put(CommandName.GOTOEXCURSIONPAGE, new GoToExcursionPage());
        commands.put(CommandName.SHOWEXCURSIONDATA, new ShowExcursionData());
        commands.put(CommandName.GOTOSHOPPINGPAGE, new GoToShoppingPage());
        commands.put(CommandName.SHOWSHOPPINGDATA, new ShowShoppingData());
        commands.put(CommandName.CHANGELANGUAGE, new ChangeLanguage());
        commands.put(CommandName.UPDATEUSERINFO, new UpdateUserInfo());
        commands.put(CommandName.UPDATEUSERDETINFO, new UpdateUserDetInfo());
        commands.put(CommandName.UPDATEBALANCE, new UpdateBalance());
        commands.put(CommandName.UPDATEUSERSALE, new UpdateUserSale());
        commands.put(CommandName.GOTOADMINPAGE, new GoToAdminPage());
        commands.put(CommandName.SAVEUSERDETAILS, new SaveUserDetails());

    }

    public Command takeCommand(String name){

        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }

}
