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

package com.tencent.tubemq.client.consumer;

import com.tencent.tubemq.client.config.ConsumerConfig;
import com.tencent.tubemq.client.exception.TubeClientException;
import com.tencent.tubemq.corebase.Shutdownable;
import java.util.Map;


public interface MessageConsumer extends Shutdownable {

    String getClientVersion();

    String getConsumerId();

    boolean isShutdown();

    ConsumerConfig getConsumerConfig();

    boolean isFilterConsume(String topic);

    Map<String, ConsumeOffsetInfo> getCurConsumedPartitions() throws TubeClientException;

    void completeSubscribe() throws TubeClientException;

    void completeSubscribe(final String sessionKey,
                           final int sourceCount,
                           final boolean isSelectBig,
                           final Map<String, Long> partOffsetMap) throws TubeClientException;

}
