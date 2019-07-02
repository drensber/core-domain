/*******************************************************************************
 * Copyright 2016-2017 Dell Inc.
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
 * @author: Jim White, Dell
 * @version: 1.0.0
 *******************************************************************************/

package org.edgexfoundry.domain.meta;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.edgexfoundry.domain.common.BaseObject;

@SuppressWarnings("serial")
public class ScheduleEvent extends BaseObject {

  // non-database identifier for a schedule event - must be unique
  private String name;

  // name to associated owning schedule
  private String schedule;

  // address (MQTT topic, HTTP address, serial bus, etc.) for the action (can be empty)
  private Addressable addressable;

  // json body for parameters
  private String parameters;

  // service associated with this event
  private String service;

  public ScheduleEvent(String name, Addressable addressable, String parameters, String schedule,
      String service) {
    super();
    this.name = name;
    this.addressable = addressable;
    this.parameters = parameters;
    this.schedule = schedule;
    this.service = service;
  }

  @SuppressWarnings("unused")
  // used by spring container
  private ScheduleEvent() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSchedule() {
    return schedule;
  }

  public void setSchedule(String schedule) {
    this.schedule = schedule;
  }

  public Addressable getAddressable() {
    return addressable;
  }

  public void setAddressable(Addressable addressable) {
    this.addressable = addressable;
  }


  public String getParameters() {
    return parameters;
  }

  public void setParameters(String parameters) {
    this.parameters = parameters;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }

  @Override
  public String toString() {
    return "ScheduleEvent [name=" + name + ", addressable=" + addressable + ", parameters="
        + parameters + ", service=" + service + ", schedule=" + schedule + ", toString()="
        + super.toString() + "]";
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(name).append(addressable)
        .append(parameters).append(service).append(schedule).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj))
      return false;
    ScheduleEvent other = (ScheduleEvent) obj;
    return propertyMatch(other);
  }

  private boolean propertyMatch(ScheduleEvent other) {
    if (!stringPropertyMatch(name, other.name))
      return false;
    if (!objectPropertyMatch(addressable, other.addressable))
      return false;
    if (!stringPropertyMatch(parameters, other.parameters))
      return false;
    if (!stringPropertyMatch(service, other.service))
      return false;
    return stringPropertyMatch(schedule, other.schedule);
  }

}
