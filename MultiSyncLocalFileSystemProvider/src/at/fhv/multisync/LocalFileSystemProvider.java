package at.fhv.multisync;

import java.io.File;

import at.fhv.multisync.bl.file.FileSystemProvider;

/**
 * 
 * File system provider for local file system.
 * 
 * @author Michael Sieber
 */
public class LocalFileSystemProvider implements FileSystemProvider {
	private final String _name = "Local File System";
	private final String _matchingProtocol = "^[a-zA-Z]://$";

	@Override
	public File[] getRoot() {
		return File.listRoots();
	}

	@Override
	public String toString() {
		return _name;
	}

	@Override
	public boolean canHandle(String protocol) {
		if (protocol == null || protocol.isEmpty()) {
			return false;
		}

		return protocol.matches(_matchingProtocol);
	}
}
