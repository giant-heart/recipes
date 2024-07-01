import React from 'react';
import { Transform } from 'ink';
import PropTypes from 'prop-types';
import gradientString from 'gradient-string';
import stripAnsi from 'strip-ansi';
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
const Gradient = props => {
    if (props.name && props.colors) {
        throw new Error('The `name` and `colors` props are mutually exclusive');
    }
    let gradient;
    if (props.name) {
        gradient = gradientString[props.name];
    }
    else if (props.colors) {
        // eslint-disable-next-line @typescript-eslint/no-unsafe-argument
        gradient = gradientString(props.colors); // TODO: Make stronger type.
    }
    else {
        throw new Error('Either `name` or `colors` prop must be provided');
    }
    const applyGradient = (text) => gradient.multiline(stripAnsi(text));
    return React.createElement(Transform, { transform: applyGradient }, props.children);
};
Gradient.propTypes = {
    children: PropTypes.oneOfType([
        PropTypes.arrayOf(PropTypes.node),
        PropTypes.node,
    ]).isRequired,
    name: PropTypes.oneOf([
        'cristal',
        'teen',
        'mind',
        'morning',
        'vice',
        'passion',
        'fruit',
        'instagram',
        'atlas',
        'retro',
        'summer',
        'pastel',
        'rainbow',
    ]),
    colors: PropTypes.arrayOf(PropTypes.oneOfType([
        PropTypes.string,
        PropTypes.object,
    ])),
};
export default Gradient;
