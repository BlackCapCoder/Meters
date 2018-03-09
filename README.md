# Meters

My solution to some Java homework.


## Testing

You can test the java solution with:

```bash
javac *.java && java Main
```

As is customary I also solved this in Haskell in opposition to OOP; you can try this with:

```bash
runhaskell Meters.hs
```

Go ahead- have a look at the Haskell. Consider how much nicer it is than java, and how it is about 100 times faster:

```bash
> time (for i in `seq 1 100`; do java Main > /dev/null; done)
4.79s

> time (for i in `seq 1 10000`; do ./main > /dev/null; done)
3.76s
```
