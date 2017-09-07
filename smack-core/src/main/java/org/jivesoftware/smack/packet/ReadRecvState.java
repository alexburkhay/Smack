/**
 *
 * Copyright 2003-2007 Jive Software.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.TypedCloneable;
import org.jivesoftware.smack.util.XmlStringBuilder;

public final class ReadRecvState extends Stanza implements TypedCloneable<ReadRecvState> {

  public static final String ELEMENT = "readrecvstate";

  public ReadRecvState() {
    super();
  }

  public ReadRecvState(ReadRecvState state) {
    super(state);
  }

  @Override
  public XmlStringBuilder toXML() {
    XmlStringBuilder buf = new XmlStringBuilder();
    buf.halfOpenElement(ELEMENT);
    addCommonAttributes(buf);
    buf.rightAngleBracket();
    buf.append(getExtensionsXML());

    // Add the error sub-packet, if there is one.
    appendErrorIfExists(buf);

    buf.closeElement(ELEMENT);
    return buf;
  }

  /**
   * Creates and returns a copy of this presence stanza.
   * <p>
   * This does not perform a deep clone, as extension elements are shared between the new and old
   * instance.
   * </p>
   * @return a clone of this presence.
   */
  @Override
  public ReadRecvState clone() {
    return new ReadRecvState(this);
  }
}
