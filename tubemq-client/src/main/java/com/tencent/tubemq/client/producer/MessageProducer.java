/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tencent.tubemq.client.producer;

import com.tencent.tubemq.client.exception.TubeClientException;
import com.tencent.tubemq.corebase.Message;
import com.tencent.tubemq.corebase.Shutdownable;
import java.util.Set;


public interface MessageProducer extends Shutdownable {

    void publish(String topic) throws TubeClientException;

    Set<String> publish(Set<String> topicSet) throws TubeClientException;

    Set<String> getPublishedTopicSet() throws TubeClientException;

    boolean isTopicCurAcceptPublish(String topic) throws TubeClientException;

    MessageSentResult sendMessage(final Message message)
            throws TubeClientException, InterruptedException;

    void sendMessage(final Message message, final MessageSentCallback cb)
            throws TubeClientException, InterruptedException;

    @Override
    void shutdown() throws Throwable;
}
