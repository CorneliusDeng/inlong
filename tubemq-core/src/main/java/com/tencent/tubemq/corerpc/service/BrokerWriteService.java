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

package com.tencent.tubemq.corerpc.service;

import com.tencent.tubemq.corebase.protobuf.generated.ClientBroker;
import com.tencent.tubemq.corerpc.client.Callback;


public interface BrokerWriteService {

    ClientBroker.SendMessageResponseB2P sendMessageP2B(ClientBroker.SendMessageRequestP2B request,
                                                       final String rmtAddress, boolean overtls) throws Throwable;

    interface AsyncService extends BrokerWriteService {

        void sendMessageP2B(ClientBroker.SendMessageRequestP2B request, final String rmtAddress,
                            boolean overtls, Callback callback) throws Throwable;

    }

}
