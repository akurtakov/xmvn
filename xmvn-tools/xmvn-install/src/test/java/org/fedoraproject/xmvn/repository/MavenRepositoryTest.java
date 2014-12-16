/*-
 * Copyright (c) 2013-2014 Red Hat, Inc.
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
package org.fedoraproject.xmvn.repository;

import java.nio.file.Paths;

import org.codehaus.plexus.PlexusTestCase;
import org.junit.Test;

import org.fedoraproject.xmvn.artifact.Artifact;
import org.fedoraproject.xmvn.artifact.DefaultArtifact;
import org.fedoraproject.xmvn.config.Configuration;
import org.fedoraproject.xmvn.config.Configurator;
import org.fedoraproject.xmvn.config.Repository;

/**
 * @author Mikolaj Izdebski
 */
public class MavenRepositoryTest
    extends PlexusTestCase
{
    @Test
    public void testMavenRepository()
        throws Exception
    {
        Configurator configurator = lookup( Configurator.class );
        Configuration configuration = configurator.getConfiguration();

        Repository repository = new Repository();
        repository.setId( "test123" );
        repository.setType( "maven" );
        configuration.addRepository( repository );

        RepositoryConfigurator repoConfigurator = lookup( RepositoryConfigurator.class );
        org.fedoraproject.xmvn.repository.Repository repo = repoConfigurator.configureRepository( "test123" );
        assertNotNull( repo );

        Artifact artifact1 = new DefaultArtifact( "foo.bar:the-artifact:baz:1.2.3" );
        ArtifactContext context = new ArtifactContext( artifact1 );
        assertEquals( Paths.get( "foo/bar/the-artifact/1.2.3/the-artifact-1.2.3.baz" ),
                      repo.getPrimaryArtifactPath( artifact1, context, "IGNORE-ME" ) );

        Artifact artifact2 = artifact1.setVersion( null );
        ArtifactContext context2 = new ArtifactContext( artifact2 );
        assertNull( repo.getPrimaryArtifactPath( artifact2, context2, "IGNORE-ME" ) );
    }
}
