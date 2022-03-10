### CompareAndSet

* CAS compareAndSet，compareAndExchange，compareAndSwap

* 这个函数会先进行比较，如果相比较的两个值是相等的，那么就进行更新操作；若不相等就不会更新，返回false

```java
AtomicInteger atomicInteger = new AtomicInteger(1);
// return true
atomicInteger.compareAndSet(1, 2);
```


```java
AtomicInteger atomicInteger = new AtomicInteger(1);
// return false
atomicInteger.compareAndSet(2, 3);
```

```java
    public final boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }
```

atomicInteger#addAndGet()的实现：var1和var2确定内存值，取出来再做cas
```java
    public final int getAndAddInt(Object var1, long var2, int var4) {
        int var5;
        do {
            var5 = this.getIntVolatile(var1, var2);
        } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

        return var5;
    }
```


