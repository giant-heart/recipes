import React from 'react';
import { Text } from 'ink';
import CFonts from 'cfonts';
const defaultCFontProps = {
    font: 'block',
    align: 'left',
    colors: ['system'],
    backgroundColor: 'transparent',
    letterSpacing: 1,
    lineHeight: 1,
    space: true,
    maxLength: 0,
};
const BigText = ({ text, ...props }) => {
    const cFontProps = { ...defaultCFontProps, ...props };
    return React.createElement(Text, null, CFonts.render(text, cFontProps).string); // eslint-disable-line @typescript-eslint/no-unsafe-call
};
export default BigText;
//# sourceMappingURL=index.js.map