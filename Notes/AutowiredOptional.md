I have commented the Autowired annotation. But still it worked. How did it work?

```
    //@Autowired
    public TennisCoach(FortuneService theFortuneService) {
        System.out.println(" theFortuneService " + theFortuneService);
        fortuneService = theFortuneService;
    }
```

This is a new feature of Spring 4.3.

Here is the snippet from the Spring Docs.

Section 1.9.2: Autowired

As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean only defines one constructor to begin with. However, if several constructors are available, at least one must be annotated to teach the container which one to use.

I personally prefer to use the @Autowired annotation because it makes the code more readable. But as mentioned, the @Autowired is not required for this scenario.

