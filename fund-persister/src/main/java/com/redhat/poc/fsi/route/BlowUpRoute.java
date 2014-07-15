/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.poc.fsi.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by ceposta (http://christianposta.com/blog)).
 */
public class BlowUpRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        getContext().getRouteDefinition("databaseRoute").adviceWith(getContext(), new AdviceWithRouteBuilder() {

            @Override
            public void configure() throws Exception {
                weaveById("persistFund").before().process(new Processor() {
                    int count = 0;

                    @Override
                    public void process(Exchange exchange) throws Exception {
                        try{
                            if (count % 3 == 2) {
                                System.out.println("blow up");
                                throw new IllegalStateException("planned blow up!!!!");
                            }
                        }
                        finally {
                            count++;
                        }

                        System.out.println("no blow up");

                    }
                });
            }
        });


    }
}
