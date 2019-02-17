package mars.model;

public enum Orientation {
	E, N, S, W;

	private Orientation right;
	private Orientation left;

	static {
		N.right = E;
		S.right = W;
		E.right = S;
		W.right = N;
	}

	static {
		N.left = W;
		S.left = E;
		E.left = N;
		W.left = S;
	}

	public Orientation getRight() {
		return right;
	}

	public Orientation getLeft() {
		return left;
	}
}
