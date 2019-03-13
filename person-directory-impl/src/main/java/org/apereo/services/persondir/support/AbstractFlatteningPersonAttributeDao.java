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
import org.apereo.services.persondir.IPersonAttributeDaoFilter;
import org.apereo.services.persondir.IPersonAttributes;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Maps calls to {@link IPersonAttributeDao#getPeople(Map, org.apereo.services.persondir.IPersonAttributeDaoFilter)} to
 * {@link IPersonAttributeDao#getPeopleWithMultivaluedAttributes(Map, org.apereo.services.persondir.IPersonAttributeDaoFilter)}
 *
 * @author Eric Dalquist

 */
public abstract class AbstractFlatteningPersonAttributeDao extends BasePersonAttributeDao {

    public AbstractFlatteningPersonAttributeDao() {
        super();
    }

    /* (non-Javadoc)
     * @see org.jasig.services.persondir.IPersonAttributeDao#getPeople(java.util.Map)
     */
    @Override
    public final Set<IPersonAttributes> getPeople(final Map<String, Object> query,
                                                  final IPersonAttributeDaoFilter filter) {
        final Map<String, List<Object>> multivaluedSeed = MultivaluedPersonAttributeUtils.toMultivaluedMap(query);
        return this.getPeopleWithMultivaluedAttributes(multivaluedSeed, filter);
    }

    /**
     * @deprecated Use {@link MultivaluedPersonAttributeUtils#toMultivaluedMap(Map)} instead. This will be removed in 1.6
     *
     * @param seed Map of seed names and values
     * @return Map of seed names with list of values
     */
    @Deprecated
    protected Map<String, List<Object>> toMultivaluedSeed(final Map<String, Object> seed) {
        return MultivaluedPersonAttributeUtils.toMultivaluedMap(seed);
    }
}
