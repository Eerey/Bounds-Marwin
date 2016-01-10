package gameobjects;

public class Cooldown {

	public int lifetime;
	public boolean triggered = true;

	public Cooldown(int lifetimeInUpdates) {
		this.lifetime = lifetimeInUpdates;
	}

	public boolean update() {
		
		if (triggered) {
			lifetime--;
			if (lifetime == 0) {
				triggered = false;
				return true;
			} else
				return false;
		} else
			return false;

	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public boolean isTriggered() {
		return triggered;
	}

	public void setTriggered(boolean triggered) {
		this.triggered = triggered;
	}

}
