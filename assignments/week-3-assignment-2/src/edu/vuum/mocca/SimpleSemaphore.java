package edu.vuum.mocca;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @class SimpleSemaphore
 *
 * @brief This class provides a simple counting semaphore
 *        implementation using Java a ReentrantLock and a
 *        ConditionObject.  It must implement both "Fair" and
 *        "NonFair" semaphore semantics, just liked Java Semaphores. 
 */
public class SimpleSemaphore {
    /**
     * Constructor initialize the data members.  
     * Define a Lock to protect the critical section.
     */
    public SimpleSemaphore (int permits,
                            boolean fair)
    { 
        // TODO - you fill in here
    	mRWLock = new ReentrantLock(fair);
    	permitted = mRWLock.newCondition();
    	mRWLock.lock(); 
    	try { 
    		availablePermits = permits; 
    	} finally { 
    		mRWLock.unlock(); 
    	} 
    }

    /**
     * Acquire one permit from the semaphore in a manner that can
     * be interrupted.
     */
    public void acquire() throws InterruptedException {
        // TODO - you fill in here
		mRWLock.lockInterruptibly();

    	try {
    		 while (availablePermits() <= 0) {
                 permitted.await();
             }
    		 --availablePermits;
    	} finally {
    		mRWLock.unlock();
    	}
    }

    /**
     * Acquire one permit from the semaphore in a manner that
     * cannot be interrupted.
     */
    public void acquireUninterruptibly() {
        // TODO - you fill in here
    	mRWLock.lock();

    	try {
    		 while (availablePermits() <= 0) {
                 permitted.await();
             }
    		 --availablePermits;
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
    		mRWLock.unlock();
    	}
    }

    /**
     * Return one permit to the semaphore.
     */
    void release() {
        // TODO - you fill in here
    	mRWLock.lock(); 
    	try { 
    		++availablePermits; 
    		permitted.signal(); 
    	} finally { 
    		mRWLock.unlock(); 
    	} 
    }
    
    /**
     * Return the number of permits available.
     */
    public int availablePermits(){
    	// TODO - you fill in here
    	mRWLock.lock(); 
    	try { 
    		return availablePermits; 
    	} finally { 
    		mRWLock.unlock(); 
    	} 
    }
    
    /**
     * Define a ReentrantLock to protect the critical section.
     */
    // TODO - you fill in here
    private ReentrantLock mRWLock;

    /**
     * Define a ConditionObject to wait while the number of
     * permits is 0.
     */
    // TODO - you fill in here
    private Condition permitted;

    /**
     * Define a count of the number of available permits.
     */
    // TODO - you fill in here.  Make sure that this data member will
    // ensure its values aren't cached by multiple Threads..
    private int availablePermits;
}

