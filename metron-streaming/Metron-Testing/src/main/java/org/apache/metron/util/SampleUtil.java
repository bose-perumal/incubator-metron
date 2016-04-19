/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.metron.util;

import org.apache.metron.domain.Configurations;
import org.apache.metron.utils.ConfigurationsUtils;

import java.io.IOException;
import java.util.Map;

public class SampleUtil {

  public static final String sampleConfigRoot = "../Metron-Testing/src/main/resources/sample/config/";

  public static
  Configurations getSampleConfigs() throws IOException {
    Configurations configurations = new Configurations();
    configurations.updateGlobalConfig(ConfigurationsUtils.readGlobalConfigFromFile(sampleConfigRoot));
    Map<String, byte[]> sensorEnrichmentConfigs = ConfigurationsUtils.readSensorEnrichmentConfigsFromFile(sampleConfigRoot);
    for(String sensorType: sensorEnrichmentConfigs.keySet()) {
      configurations.updateSensorEnrichmentConfig(sensorType, sensorEnrichmentConfigs.get(sensorType));
    }
    return configurations;
  }

}
