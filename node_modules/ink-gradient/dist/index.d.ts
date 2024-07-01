import { type FC as ReactFC, type ReactNode } from 'react';
export type GradientName = 'cristal' | 'teen' | 'mind' | 'morning' | 'vice' | 'passion' | 'fruit' | 'instagram' | 'atlas' | 'retro' | 'summer' | 'pastel' | 'rainbow';
export type GradientColors = Array<string | Record<string, unknown>>;
export type Props = {
    readonly children: ReactNode;
    /**
    The name of a [built-in gradient](https://github.com/bokub/gradient-string#available-built-in-gradients).

    Mutually exclusive with `colors`.
    */
    readonly name?: GradientName;
    /**
    [Colors to use to make the gradient.](https://github.com/bokub/gradient-string#initialize-a-gradient)

    Mutually exclusive with `name`.
    */
    readonly colors?: GradientColors;
};
/**
@example
```
import React from 'react';
import {render} from 'ink';
import Gradient from 'ink-gradient';
import BigText from 'ink-big-text';

render(
    <Gradient name="rainbow">
        <BigText text="unicorns"/>
    </Gradient>
);
```
*/
declare const Gradient: ReactFC<Props>;
export default Gradient;
