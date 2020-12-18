/*
 * Copyright (c) 2017, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.ts.tests.jpa.jpa22.se.generators.sequencegenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
import jakarta.persistence.Table;

@Entity
@Table(name = "SCHEMAGENSIMPLE")
@SequenceGenerators(@SequenceGenerator(name = "SEQGENERATOR", allocationSize = 1, initialValue = 10))
public class Simple implements java.io.Serializable {
  private static final long serialVersionUID = 22L;

  // ===========================================================
  // instance variables
  int id;

  // ===========================================================
  // constructors
  public Simple() {
  }

  public Simple(int id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQGENERATOR")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    // check for self-comparison
    if (this == o)
      return true;
    if (!(o instanceof Simple))
      return false;

    Simple o1 = (Simple) o;

    boolean result = false;

    if (this.getId() == o1.getId()) {
      result = true;
    }

    return result;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(this.getClass().getSimpleName() + "[");
    result.append("id: " + getId());
    result.append("]");
    return result.toString();
  }

}
