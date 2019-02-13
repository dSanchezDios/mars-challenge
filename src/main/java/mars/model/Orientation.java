package mars.model;

enum Orientation {
	E,
	N;

	private Orientation right;

	static {
		N.right = E;
	}

	public Orientation getRight() {
		return right;
	}
}
