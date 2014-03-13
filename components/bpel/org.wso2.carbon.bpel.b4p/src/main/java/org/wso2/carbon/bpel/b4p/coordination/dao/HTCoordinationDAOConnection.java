/*
 * Copyright (c), WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.bpel.b4p.coordination.dao;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * This interface will be used through out the human task engine implementation to make the logic
 * neutral of the underlying database ORM entity.
 */
public interface HTCoordinationDAOConnection {

    /**
     * Create HTProtocolHandler Object and persists it in database according to data provided
     * @param messageID : UUID generated by b4p component
     * @param htProtocolHandlerURL : Task's Protocol Handler URL
     * @return : a HTProtocolHandler
     */
    HTProtocolHandlerDAO createCoordinatedTask(String messageID,String htProtocolHandlerURL);

    /**
     * Create HTProtocolHandler Object and persists it in database according to data provided
     * @param messageID UUID generated by b4p component
     * @param htProtocolHandlerURL Task's Protocol Handler URL
     * @param processInstanceID process instanceID
     * @param taskID task ID
     * @return HTProtocolHandler
     */
    HTProtocolHandlerDAO createCoordinatedTask(String messageID,String htProtocolHandlerURL, String processInstanceID, String taskID);

    /**
     * Update Process instance, Task ID field for given message ID.
     * @param messageID is String value of a UUID
     * @param processInstanceID process instance ID
     * @param taskID humanTask ID
     */
    void updateProtocolHandler(String messageID, String processInstanceID, String taskID);

    /**
     * Return HTProtocolHandler Entity list for given process instance ID.
     * @param processInstanceID process instance ID.
     * @return HTProtocolHandler Entity list
     */
    List<HTProtocolHandlerDAO> getProtocolHandlers(String processInstanceID);

    /**
     * Return TaskProtocolHandlers list for given process instance ID
     * @param processInstanceID process instance ID.
     * @return corresponding TaskProtocolHandler list.
     */
    List<TaskProtocolHandler> getProtocolHandlerURLsWithTasks(String processInstanceID);

    /**
     * Delete all protocol data related to particular Process instance ID.
     * @param processInstanceID Process Instance ID
     * @return true if delete success.
     */
    boolean deleteCoordinationData(String processInstanceID);


    /**
     * Delete Protocol handler data for particular Task id.
     * @param taskID HumanTask ID.
     * @return true if delete success.
     */
    boolean deleteTaskData(String taskID);

    /**
     * Return the Entity Manager
     * @return EntityManager
     */
    EntityManager getEntityManager();

}