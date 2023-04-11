package com.orion.core.computation.parallelism;

// @RunWith(ConcurrentJUnitRunner.class)
public class ParallelExecutorTest
{
    /*@Test
    public void test_forLoop_accessAtomicObject() throws MultipleExecutionException
    {
        final AtomicInteger sum = new AtomicInteger(0);
        new ParallelFor().forEach(1, 10001, new LoopBody()
        {
            @Override
            public void run(int i) throws Exception
            {
                sum.addAndGet(i);
            }
        });
        assertEquals("sum of indices", 50005000, sum.get());
    }


    @Test
    public void test_executeAllList_0010() throws MultipleExecutionException
    {
        final int taskSize = 100;
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>(taskSize);

        for(int i = 0; i < taskSize; ++i)
        {
            final int I = i;
            tasks.add(new Callable<Integer>()
            {
                @Override
                public Integer call() throws Exception
                {
                    int sum = 0;

                    for(int i = 1; i <= 10000; ++i)
                    {
                        sum += i;
                    }

                    return sum + I;
                }
            });
        }

        Integer[] sums = new Integer[taskSize];
        Arrays.fill(sums, 50005000);

        for(int i = 0; i < taskSize; ++i)
        {
            sums[i] += i; // check if the results are in sequence
        }

        List<Integer> expResult = Arrays.<Integer>asList(sums);
        List<Integer> result = new ParallelExecutor().run(tasks);
        assertEquals(expResult, result);
    }


    @Test
    public void test_executeAllVarArg_0010() throws MultipleExecutionException
    {
        @SuppressWarnings("unchecked")
        List<Integer> results = new ParallelExecutor().run(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 1;
            }
        }, new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 2;
            }
        });
        assertEquals("results should be in the same sequential order as input tasks", Arrays.asList(1, 2), results);
    }


    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void test_executeAnyVarArg_0010() throws ExecutionException
    {
        ParallelExecutor parallel = new ParallelExecutor(2);
        @SuppressWarnings("unchecked")
        Integer result = parallel.runAndReturnFirstResult(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                throw new Exception("test");
            }
        }, new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                throw new RuntimeException("runtime");
            }
        }, new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                Thread.sleep(100000); // longer execution time
                return 100;
            }
        }, new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 1;
            }
        });
        assertEquals(1, result.intValue());
    }*/
    /*@Test
    public void test_forLoop_assignArrayEntries() throws MultipleExecutionException
    {
        final double[] array = new double[1000];
        new ParallelExecutor().forLoop(0, array.length, new LoopBody()
        {

            @Override
            public void run(int i) throws Exception
            {
                array[i] = i; // assign all elements in parallel
            }
        });

        double[] expResult = R.seq(0., array.length - 1, 1.);

        assertArrayEquals(expResult, array, 1e-15);
    }*/
    /*@Test
    public void test_forLoop_nestedLoops() throws MultipleExecutionException
    {
        final double[][] array2d = new double[20000][20000];
        new ParallelFor().forEach(0, array2d.length, new LoopBody()
        {
            @Override
            public void run(final int i) throws Exception
            {

                for(int j = 0; j < array2d[i].length; ++j)
                {
                    array2d[i][j]++; // nested loop for incrementing 2D array
                }

            }
        });

        for(int i = 0; i < array2d.length; ++i)
        {

            for(int j = 0; j < array2d[i].length; ++j)
            {
                assertEquals("all 1's", 1., array2d[i][j], 1e-15);
            }

        }

    }*/
    /*@Test
    public void test_forLoop_assignMatrixEntries() throws MultipleExecutionException
    {
        final int matrixSize = 10;
        IID iid = new IID(new UniformRng(), matrixSize * matrixSize);
        final Matrix A1 = new DenseMatrix(iid.nextVector(), matrixSize, matrixSize);
        final Matrix A2 = new DenseMatrix(matrixSize, matrixSize);
        A2.set(1, 1, 0.); // trigger space allocation in the main thread
        new ParallelExecutor().forLoop(1, matrixSize + 1, new LoopBody()
        {

            @Override
            public void run(int i) throws Exception
            {
                for(int j = 1; j <= matrixSize; ++j)
                {
                    A2.set(i, j, A1.get(i, j));
                }
            }
        });

        assertTrue(A1 + " does not equal to " + A2, AreMatrices.equal(A1, A2, 1e-15));
    }*/
    /*@Test
    public void test_forLoop_blockIncrement() throws MultipleExecutionException
    {
        final int increment = 10;
        final double[] array = new double[100000000];
        new ParallelFor().forEach(0, array.length, increment, new LoopBody()
        {
            @Override
            public void run(int i) throws Exception
            {
                array[i] = i; // increment all elements in parallel
            }
        });
        double[] expResult = new double[100000000];

        for(int i = 0; i < expResult.length; i += increment)
        {
            expResult[i] = i;
        }

        assertArrayEquals(expResult, array, 1e-15);
    }


    @Test
    public void test_forEach_0010() throws MultipleExecutionException
    {
        int size = 100;
        List<Integer> list = new ArrayList<Integer>(size);

        for(int i = 0; i < size; ++i)
        {
            list.add(i);
        }

        final AtomicInteger sum = new AtomicInteger(0);
        new ParallelFor().forEach(list, new IterationBody<Integer>()
        {
            @Override
            public void run(Integer item)
            {
                sum.addAndGet(item);
            }
        });
        assertEquals(4950, sum.get());
    }


    @Test
    public void test_forEach_0020() throws MultipleExecutionException
    {
        List<Integer> list = Collections.<Integer>emptyList();
        final AtomicInteger sum = new AtomicInteger(0);
        new ParallelFor().forEach(list, new IterationBody<Integer>()
        {
            @Override
            public void run(Integer item)
            {
                sum.addAndGet(item);
            }
        });
        assertEquals(0, sum.get());
    }


    @Test
    public void test_reusability_0010() throws MultipleExecutionException
    {
        ParallelExecutor executor = new ParallelExecutor();
        @SuppressWarnings("unchecked")
        List<Integer> results1 = executor.run(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 1;
            }
        });
        assertEquals(Arrays.asList(1), results1);
        // reuse the executor
        @SuppressWarnings("unchecked")
        List<Integer> results2 = executor.run(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                return 2;
            }
        });
        assertEquals(Arrays.asList(2), results2);
    }*/
}
