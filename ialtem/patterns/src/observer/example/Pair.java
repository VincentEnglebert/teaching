package observer.example;

public class Pair<A, B> {

	public final A first;
	public final B second;

	public Pair(A f, B s) {
		first = f;
		second = s;
	}

	public Pair<A, B> setFirst(A f) {
		return new Pair<A, B>(f, second);
	}

	public Pair<A, B> setSecond(B s) {
		return new Pair<A, B>(first, s);
	}

	@Override
	public String toString() {
		return String.format("(%s,%s)", first == null ? "null" : first.toString(),
				second == null ? "null" : second.toString());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Pair<A, B> other = (Pair<A, B>) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

}
