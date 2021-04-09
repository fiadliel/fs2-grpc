/*
 * Copyright (c) 2018 Gary Coady
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.lyranthe.fs2_grpc
package java_runtime
package server

sealed abstract class ServerCompressor(val name: String) extends Product with Serializable
case object GzipCompressor extends ServerCompressor("gzip")

abstract class ServerCallOptions private (val compressor: Option[ServerCompressor]) {
  def copy(compressor: Option[ServerCompressor] = this.compressor): ServerCallOptions =
    new ServerCallOptions(compressor) {}

  def withServerCompressor(compressor: Option[ServerCompressor]): ServerCallOptions =
    copy(compressor)
}

object ServerCallOptions {
  val default: ServerCallOptions = new ServerCallOptions(None) {}
}
