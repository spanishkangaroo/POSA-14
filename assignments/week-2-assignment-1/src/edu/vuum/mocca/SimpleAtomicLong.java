// Import the necessary Java synchronization and scheduling classes.

package edu.vuum.mocca;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @class SimpleAtomicLong
 *
 * @brief This class implements a subset of the
 *        java.util.concurrent.atomic.SimpleAtomicLong class using a
 *        ReentrantReadWriteLock to illustrate how they work.
 */
class SimpleAtomicLong
{
    /**
     * The value that's manipulated atomically via the methods.
     */
    private long mValue;


    /**
     * The ReentrantReadWriteLock used to serialize access to mValue.
     */
<<<<<<< HEAD

    // TODO -- you fill in here by replacing the null with an
    // initialization of ReentrantReadWriteLock.
    private ReentrantReadWriteLock mRWLock = new ReentrantReadWriteLock(true);
=======
    // TODO - add the implementation
>>>>>>> upstream/master

    /**
     * Creates a new SimpleAtomicLong with the given initial value.
     */
<<<<<<< HEAD
    public SimpleAtomicLong(long initialValue)
    {
        // TODO -- you fill in here
    	mRWLock.writeLock().lock();
    	mValue = initialValue;
    	mRWLock.writeLock().unlock();
=======
    public SimpleAtomicLong(long initialValue) {
        // TODO - you fill in here
>>>>>>> upstream/master
    }

    /**
     * @brief Gets the current value
     * 
     * @returns The current value
     */
<<<<<<< HEAD
    public long get()
    {
        long value;

        // TODO -- you fill in here
        mRWLock.readLock().lock();
        value = mValue;
        mRWLock.readLock().unlock();
        
        return value;
=======
    public long get() {
        // TODO - you fill in here
>>>>>>> upstream/master
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the updated value
     */
<<<<<<< HEAD
    public long decrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        mValue = mValue - 1;
        value = mValue;
        mRWLock.writeLock().unlock();
        
        return value;
=======
    public long decrementAndGet() {
        // TODO - you fill in here
>>>>>>> upstream/master
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndIncrement()
    {
        long value = 0;

        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        value = mValue;
        mValue = mValue + 1;
        mRWLock.writeLock().unlock();
        
        return value;
=======
    public long getAndIncrement() {
        // TODO - you fill in here
>>>>>>> upstream/master
    }

    /**
     * @brief Atomically decrements by one the current value
     *
     * @returns the previous value
     */
<<<<<<< HEAD
    public long getAndDecrement()
    {
        long value = 0;

        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        value = mValue;
        mValue = mValue - 1;
        mRWLock.writeLock().unlock();

        return value;
=======
    public long getAndDecrement() {
        // TODO - you fill in here
>>>>>>> upstream/master
    }

    /**
     * @brief Atomically increments by one the current value
     *
     * @returns the updated value
     */
<<<<<<< HEAD
    public long incrementAndGet()
    {
        long value = 0;

        // TODO -- you fill in here
        mRWLock.writeLock().lock();
        mValue = mValue + 1;
        value = mValue;
        mRWLock.writeLock().unlock();
        
        return value;
=======
    public long incrementAndGet() {
        // TODO - you fill in here
>>>>>>> upstream/master
    }
}

