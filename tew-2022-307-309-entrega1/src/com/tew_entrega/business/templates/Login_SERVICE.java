package com.tew_entrega.business.templates;

import com.tew_entrega.model.Usuario;

public interface Login_SERVICE {

	Usuario getLogin(String login, String password);

}
