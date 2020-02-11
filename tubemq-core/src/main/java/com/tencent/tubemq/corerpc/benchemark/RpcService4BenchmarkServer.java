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

package com.tencent.tubemq.corerpc.benchemark;

import com.tencent.tubemq.corerpc.RpcConfig;
import com.tencent.tubemq.corerpc.RpcServiceFactory;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RpcService4BenchmarkServer {

    private static final Logger logger =
            LoggerFactory.getLogger(RpcService4BenchmarkServer.class);
    private final RpcServiceFactory rpcServiceFactory =
            new RpcServiceFactory();
    private SimpleService simpleService;

    public static void main(String[] args) throws Exception {
        new RpcService4BenchmarkServer().start();
    }

    public void start() throws Exception {
        simpleService = new DefaultSimpleService();
        RpcConfig config = new RpcConfig();
        rpcServiceFactory.publishService(SimpleService.class, simpleService, 8088,
                Executors.newCachedThreadPool(), config);
    }
}
