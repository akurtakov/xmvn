/*-
 * Copyright (c) 2014 Red Hat, Inc.
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
package org.fedoraproject.xmvn.tools.install.impl;

import java.io.IOException;

import org.eclipse.aether.artifact.Artifact;

import org.fedoraproject.xmvn.config.PackagingRule;

/**
 * @author Mikolaj Izdebski
 */
public interface ArtifactInstaller
{
    void installArtifact( Package pkg, Artifact artifact, PackagingRule rule, String packageName )
        throws IOException;
}
