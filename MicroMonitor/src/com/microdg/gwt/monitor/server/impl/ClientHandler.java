package com.microdg.gwt.monitor.server.impl;

import java.util.ArrayList;

import com.microdg.gwt.monitor.server.ClientHandlerTemplate;
import com.microdg.gwt.monitor.shared.FieldException;
import com.microdg.gwt.monitor.shared.FieldVerifier;
import com.microdg.gwt.monitor.shared.SimpleException;
import com.microdg.gwt.monitor.shared.dto.ClientDTO;

/**
 * <pre>   Copyright 2013 Ansel Robateau
         http://www.robaone.com

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.</pre>
 * @author Ansel
 *
 */
public class ClientHandler implements ClientHandlerTemplate {

	@Override
	public ClientDTO[] getClients() throws SimpleException {
		ArrayList<ClientDTO> clients = new ArrayList<ClientDTO>();
		for(int i = 0; i < 10;i++){
			ClientDTO client = new ClientDTO();
			client.setClientId(i);
			client.setName("Client number "+ (i+1));
			clients.add(client);
		}
		return clients.toArray(new ClientDTO[0]);
	}

	@Override
	public ClientDTO saveClient(ClientDTO message) throws SimpleException,
			FieldException {
		System.out.println("Saving "+message.getName());
		if("error".equalsIgnoreCase(message.getName())){
			throw new SimpleException("This is a general error");
		}else if(!FieldVerifier.exists(message.getName())){
			FieldException fe = new FieldException();
			fe.addError("name", "You must supply a name");
			throw fe;
		}
		if(message.getClientId() == null){
			message.setClientId(1);
		}
		return message;
	}

	@Override
	public ClientDTO getClient(Integer clientId) throws SimpleException {
		ClientDTO savedClient = new ClientDTO();
		savedClient.setClientId(clientId);
		savedClient.setName("Saved Client Record");
		return savedClient;
	}

}
