/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apereo.services.persondir.support;

import org.apereo.services.persondir.IPersonAttributeDao;

/**
 * Optional interface that can be implemented by users of person directory to tell attribute sources the userName of the
 * current user. This is useful for sources such as {@link AdditionalDescriptorsPersonAttributeDao} where the additional
 * attributes may only be applicable for queries related to the current user of the system, and not for other users the
 * current user is getting attribute information for. 
 *
 * @author Eric Dalquist

 */
public interface ICurrentUserProvider {
    /**
     * @return The userName of the user calling the {@link IPersonAttributeDao} API
     */
    public String getCurrentUserName();
}
