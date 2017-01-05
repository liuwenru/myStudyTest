package org.ijarvis.EpointTest.AtmosphereWebsocket;

import java.net.URI;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterConfig;
import org.atmosphere.cpr.BroadcasterLifeCyclePolicy;
import org.atmosphere.cpr.BroadcasterLifeCyclePolicyListener;
import org.atmosphere.cpr.BroadcasterListener;

public class AtmosphereBroadcaster implements Broadcaster {

	@Override
	public Broadcaster addAtmosphereResource(AtmosphereResource arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBroadcasterLifeCyclePolicyListener(BroadcasterLifeCyclePolicyListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Broadcaster addBroadcasterListener(BroadcasterListener arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> awaitAndBroadcast(Object arg0, long arg1, TimeUnit arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> broadcast(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> broadcast(Object arg0, AtmosphereResource arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> broadcast(Object arg0, Set<AtmosphereResource> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> broadcastOnResume(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> delayBroadcast(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> delayBroadcast(Object arg0, long arg1, TimeUnit arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<AtmosphereResource> getAtmosphereResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BroadcasterConfig getBroadcasterConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BroadcasterLifeCyclePolicy getBroadcasterLifeCyclePolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SCOPE getScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Broadcaster initialize(String arg0, URI arg1, AtmosphereConfig arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void releaseExternalResources() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Broadcaster removeAtmosphereResource(AtmosphereResource arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBroadcasterLifeCyclePolicyListener(BroadcasterLifeCyclePolicyListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Broadcaster removeBroadcasterListener(BroadcasterListener arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resumeAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Future<Object> scheduleFixedBroadcast(Object arg0, long arg1, TimeUnit arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<Object> scheduleFixedBroadcast(Object arg0, long arg1, long arg2, TimeUnit arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBroadcasterConfig(BroadcasterConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBroadcasterLifeCyclePolicy(BroadcasterLifeCyclePolicy arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setID(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScope(SCOPE arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSuspendPolicy(long arg0, POLICY arg1) {
		// TODO Auto-generated method stub
		
	}

}
