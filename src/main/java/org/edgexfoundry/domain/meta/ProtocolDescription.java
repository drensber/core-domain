/*******************************************************************************
 * Copyright 2019 Beechwoods Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * @microservice: core-domain library
 * @author: Dave Rensberger, Beechwoods
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.domain.meta;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.edgexfoundry.domain.common.BaseObject;

import java.util.Map;
import java.util.HashMap;

//@Document
@SuppressWarnings("serial")
public class ProtocolDescription {
    public ProtocolDetails details;

    public static class ProtocolDetails {
	private Map<String,String> detail_map = new HashMap<>();
	
	@JsonAnySetter
	public void add(String key, String value) {
	    detail_map.put(key, value);
	}

	public void setDetail_map(String key, String value) {
	    detail_map.put(key, value);
	}
    }
}

