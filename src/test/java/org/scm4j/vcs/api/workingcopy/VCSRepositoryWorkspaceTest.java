package org.scm4j.vcs.api.workingcopy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VCSRepositoryWorkspaceTest extends VCSWCTestBase {

	@Test
	public void testVCSRepository() throws Exception {
		IVCSWorkspace w = new VCSWorkspace(WORKSPACE_DIR);
		IVCSRepositoryWorkspace r = w.getVCSRepositoryWorkspace(TEST_REPO_URL);
		assertEquals(r.getRepoUrl(), TEST_REPO_URL);
		assertTrue(r.getRepoFolder().exists());
		assertTrue(r.getRepoFolder().getParentFile().getPath().equals(WORKSPACE_DIR));
		assertEquals(r.getWorkspace(), w);
		
		IVCSRepositoryWorkspace r1 = w.getVCSRepositoryWorkspace(TEST_REPO_URL);
		assertEquals(r1.getRepoFolder().getPath(), r.getRepoFolder().getPath());
		
		try (IVCSLockedWorkingCopy lwc = r.getVCSLockedWorkingCopy()) {
			assertEquals(lwc.getVCSRepository(), r);
		}
	}
}
