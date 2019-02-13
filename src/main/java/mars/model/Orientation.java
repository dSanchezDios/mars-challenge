package mars.model;

enum Orientation {
	E, N, S, W;

	private Orientation right;

	static {
		N.right = E;
		S.right = W;
		E.right = S;
		W.right = N;
	}

	public Orientation getRight() {
		return right;
	}
}
