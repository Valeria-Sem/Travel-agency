package com.epam.travelAgency.controller.command;

import com.epam.travelAgency.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, Command> commands = new HashMap<>();

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

    }

    public Command takeCommand(String name){
        CommandName commandName;
        commandName = CommandName.valueOf(name.toUpperCase());

        return commands.get(commandName);
    }

}
