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
package org.fedoraproject.xmvn.artifact;

import java.io.File;

/**
 * @author Mikolaj Izdebski
 */
public interface Artifact
{
    String getGroupId();

    String getArtifactId();

    String getExtension();

    String getClassifier();

    String getVersion();

    File getFile();

    String getScope();

    String getStereotype();

    Artifact setVersion( String version );

    Artifact setFile( File file );

    Artifact setScope( String scope );

    Artifact setStereotype( String stereotype );
}