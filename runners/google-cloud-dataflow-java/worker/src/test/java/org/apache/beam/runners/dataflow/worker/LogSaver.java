/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.runners.dataflow.worker;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import javax.annotation.concurrent.ThreadSafe;

/** A JUL logging {@link Handler} that records all logging events that are passed to it. */
@ThreadSafe
public class LogSaver extends Handler {
  private final Collection<LogRecord> logRecords = new ConcurrentLinkedDeque<>();

  public Collection<LogRecord> getLogs() {
    return logRecords;
  }

  @Override
  public void publish(LogRecord record) {
    logRecords.add(record);
  }

  @Override
  public void flush() {}

  @Override
  public void close() throws SecurityException {}
}
