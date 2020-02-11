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

package com.tencent.tubemq.server.common.utils;

import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);


    public static boolean fullyDelete(File dir) throws IOException {
        if (!fullyDeleteContents(dir)) {
            return false;
        }
        return dir.delete();
    }

    public static boolean fullyDeleteContents(File dir) throws IOException {
        boolean deletionSucceeded = true;
        File[] contents = dir.listFiles();
        if (contents != null) {
            for (int i = 0; i < contents.length; i++) {
                if (contents[i].isFile()) {
                    if (!contents[i].delete()) {
                        deletionSucceeded = false;
                    }

                } else {
                    if (contents[i].delete()) {
                        continue;
                    }

                    if (!fullyDelete(contents[i])) {
                        deletionSucceeded = false;
                    }
                }
            }
        }
        return deletionSucceeded;
    }

    public static void checkDir(final File dir) {
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException(new StringBuilder(512)
                        .append("Create directory failed:")
                        .append(dir.getAbsolutePath()).toString());
            }
        }
        if (!dir.isDirectory()) {
            throw new RuntimeException(new StringBuilder(512)
                    .append("Path is not a directory:")
                    .append(dir.getAbsolutePath()).toString());
        }
    }


}
