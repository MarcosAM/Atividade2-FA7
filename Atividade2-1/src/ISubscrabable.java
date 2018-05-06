
public interface ISubscrabable {
	public void addSubscriber(IUpdatable subscriber);
	public void removeSubscriber(IUpdatable subscriber);
	public void updateSubscribers();
}
