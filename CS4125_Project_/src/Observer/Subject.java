package Observer;

public interface Subject {
	public void registerOb(Observer o);
	public void removerOb(Observer o);
	public void notifyOb();
}
