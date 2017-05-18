package org.jenkinsci.extension_indexer;

import net.sf.json.JSONObject;
import org.jvnet.hudson.update_center.MavenArtifact;

/**
 * Captures key details of {@link Extension} but without keeping much of the work in memory.
 *
 * @author Kohsuke Kawaguchi
 * @see Extension
 */
public class ExtensionSummary {
    /**
     * Back reference to the artifact where this implementation was found.
     */
    public final MavenArtifact artifact;

    public final String extensionPoint;

    public final String implementation;

    public final String documentation;

    public final JSONObject json;

    public ExtensionSummary(Extension e) {
        this.artifact = e.artifact;
        this.extensionPoint = e.extensionPoint.getQualifiedName().toString();
        this.implementation = e.implementation!=null ? e.implementation.getQualifiedName().toString() : null;
        this.documentation = e.getDocumentationString();
        this.json = e.toJSON();
    }
}
