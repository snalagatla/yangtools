/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.model.immutable;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.model.api.DataNodeContainer;
import org.opendaylight.yangtools.yang.model.api.DataSchemaNode;

abstract class AbstractDataNodeContainer implements DataNodeContainer {

    abstract Map<QName, DataSchemaNode> children();

    @Override
    public final Collection<DataSchemaNode> getChildNodes() {
        return children().values();
    }

    @Override
    public final Optional<DataSchemaNode> findDataChildByName(final QName name) {
        return Optional.ofNullable(children().get(requireNonNull(name)));
    }
}
