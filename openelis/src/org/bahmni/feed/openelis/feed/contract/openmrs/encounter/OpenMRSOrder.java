/*
* The contents of this file are subject to the Mozilla Public License
* Version 1.1 (the "License"); you may not use this file except in
* compliance with the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/ 
* 
* Software distributed under the License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific language governing rights and limitations under
* the License.
* 
* The Original Code is OpenELIS code.
* 
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
*/

package org.bahmni.feed.openelis.feed.contract.openmrs.encounter;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMRSOrder {
    private String uuid;
    private OpenMRSOrderType orderType;
    private OpenMRSConcept concept;

    public String getUuid() {
        return uuid;
    }

    public OpenMRSOrderType getOrderType() {
        return orderType;
    }

    public OpenMRSConcept getConcept() {
        return concept;
    }

    public void setOrderType(OpenMRSOrderType orderType) {
        this.orderType = orderType;
    }

    public void setConcept(OpenMRSConcept concept) {
        this.concept = concept;
    }

    public boolean isLabOrder() {
        return orderType.isLabOrder();
    }

    public boolean isLabOrderForPanel() {
        return concept != null && concept.isSet();
    }

    public String getLabTestName() {
        if (!isLabOrder())
            return null;
        return concept.getName().getName();
    }

    public String getTestOrPanelUUID() {
        if (!isLabOrder())
            return null;
        return concept.getUuid();
    }
}