---
title: Best Practices
permalink: pmd_userdocs_best_practices.html
author: Tom Copeland <tom@infoether.com>
---

## Choose the rules that are right for you

Running every ruleset will result in a huge number of rule violations, most of which will be unimportant.
Having to sort through a thousand line report to find the few you're really interested in takes
all the fun out of things.

Instead, start with some of the obvious rulesets - just run [unusedcode](/pmd_rules_java.html#unused-code) and fix any unused locals and fields.
Then, run [empty](/pmd_rules_java.html#empty-code) and fix all the empty `if` statements and such-like. After that, take [unnecessary](/pmd_rules_java.html#unnecessary)
and fix these violations. Then, run [basic](/pmd_rules_java.html#basic) and fix the remaining violations.
Then peruse the [design](/pmd_rules_java.html#design) and [controversial](/pmd_rules_java.html#controversial) rulesets and use the ones
you like [via a custom ruleset](/pmd_userdocs_understanding_rulesets.html).

## PMD rules are not set in stone

Generally, pick the ones you like, and ignore or [suppress](/pmd_userdocs_suppressing.html) the warnings you don't like. It's just a tool.

## PMD IDE plugins are nice

Using PMD within your IDE is much more enjoyable than flipping back and forth
between an HTML report and your IDE. Most IDE plugins have the "click on the rule
violation and jump to that line of code" feature. Find the PMD plugin for your IDE, install it,
and soon you'll be fixing problems much faster.

Suggestions?  Comments?  Post them [here](https://github.com/pmd/pmd/issues). Thanks!
