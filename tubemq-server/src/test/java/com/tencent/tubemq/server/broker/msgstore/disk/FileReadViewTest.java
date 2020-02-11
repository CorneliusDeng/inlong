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

package com.tencent.tubemq.server.broker.msgstore.disk;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.springframework.util.Assert;

/***
 * FileReadView test
 */
public class FileReadViewTest {

    @Test
    public void read() {
        File file = new File("src/test/resource/testdata");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            // create file segment
            Segment segment = new FileSegment(0, file, true, SegmentType.DATA);
            String data = "abcdefghij";
            byte[] bytes = data.getBytes();
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            // write data to FileSegment
            segment.append(buf);
            segment.flush(true);
            FileReadView fileReadView = new FileReadView(segment, 0, 10, 10);
            ByteBuffer bf = ByteBuffer.allocate(10);
            // read data to bf
            fileReadView.read(bf, 0);
            String readData = new String(bf.array());
            Assert.isTrue(readData.equals(data));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
