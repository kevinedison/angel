/*
 * Tencent is pleased to support the open source community by making Angel available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */


package com.tencent.angel.spark.ml.classification

import com.tencent.angel.ml.core.conf.MLConf
import com.tencent.angel.ml.core.network.layers.verge.{SimpleLossLayer, SimpleInputLayer}
import com.tencent.angel.ml.core.network.transfunc.Identity
import com.tencent.angel.ml.core.optimizer.Adam
import com.tencent.angel.ml.core.optimizer.loss.LogLoss
import com.tencent.angel.spark.ml.core.GraphModel

class LogisticRegression extends GraphModel {

  val lr = conf.getDouble(MLConf.ML_LEARN_RATE)

  override
  def network(): Unit = {
    val input = new SimpleInputLayer("input", 1, new Identity(), new Adam(lr))
    new SimpleLossLayer("simpleLossLayer", input, new LogLoss)
  }
}