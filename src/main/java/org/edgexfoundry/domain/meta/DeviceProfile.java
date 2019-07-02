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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.edgexfoundry.domain.common.DescribedObject;

@SuppressWarnings("serial")
public class DeviceProfile extends DescribedObject implements Serializable {

  // non-database identifier for a device profile must be unique
  private String name;

  // manufacture of the device
  private String manufacturer;

  // model of the device
  private String model;

  // tag or label used by services to identify or search for groups of
  // profiles
  private String[] labels;

  // device service used JSON data that is required to communicate with
  // devices of this profile type
  private Object objects;

  private List<DeviceObject> deviceResources;

  // device service used object actions that are optionally used to map
  // commands to objects of devices of this profile type
  private List<ProfileResource> deviceCommands;

  // list of commands to get/put information from the associated devices of
  // this profile type
  private List<Command> coreCommands;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String[] getLabels() {
    return labels;
  }

  public void setLabels(String[] labels) {
    this.labels = labels;
  }

  public Object getObjects() {
    return objects;
  }

  public void setObjects(Object objects) {
    this.objects = objects;
  }

  public List<DeviceObject> getDeviceResources() {
    return deviceResources;
  }

  public void setDeviceResources(List<DeviceObject> deviceResources) {
    this.deviceResources = deviceResources;
  }

  public List<Command> getCoreCommands() {  
    return coreCommands;
  }

  public void setCoreCommands(List<Command> coreCommands) {
    this.coreCommands = coreCommands;
  }

  public void addCoreCommand(Command coreCommand) {
    if (this.coreCommands == null)
      this.coreCommands = new ArrayList<>();
    this.coreCommands.add(coreCommand);
  }

  public boolean removeCoreCommand(Command coreCommand) {
    if (this.coreCommands == null)
      this.coreCommands = new ArrayList<>();
    return this.coreCommands.remove(coreCommand);
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(coreCommands)
        .append(Arrays.hashCode(labels)).append(manufacturer).append(model).append(name)
        .append(objects).append(deviceCommands).toHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj))
      return false;
    DeviceProfile other = (DeviceProfile) obj;
    return propertyMatch(other);
  }

  private boolean propertyMatch(DeviceProfile other) {
    if (!comparePropertyLists(coreCommands, other.coreCommands))
      return false;
    if (!stringArrayPropertyMatch(labels, other.labels))
      return false;
    if (!stringPropertyMatch(manufacturer, other.manufacturer))
      return false;
    if (!stringPropertyMatch(model, other.model))
      return false;
    if (!stringPropertyMatch(name, other.name))
      return false;
    if (!objectPropertyMatch(objects, other.objects))
      return false;
    return true;
  }

  private boolean comparePropertyLists(List<?> thisList, List<?> otherList) {
    if (thisList == null) {
      if (otherList != null)
        return false;
    } else {
      if (otherList == null)
        return false;
      if (thisList.size() != otherList.size())
        return false;
      int i = 0;
      for (Object object : thisList) {
        if (!object.equals(otherList.get(i)))
          return false;
        i++;
      }
    }
    return true;
  }

  @Override
  public String toString() {
    return "DeviceProfile [name=" + name + ", manufacturer=" + manufacturer + ", model=" + model
        + ", labels=" + Arrays.toString(labels) + ", deviceResources=" + deviceResources + ", deviceCommands="
        + deviceCommands + ", coreCommands=" + coreCommands + "]";
  }

  public List<ProfileResource> getDeviceCommands() {
    return deviceCommands;
  }

  public void setDeviceCommands(List<ProfileResource> deviceCommands) {
    this.deviceCommands = deviceCommands;
  }

}
